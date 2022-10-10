package com.radenmas.trendsmarketplace.ui.shopee

import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.TextView.OnEditorActionListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.radenmas.trendsmarketplace.adapter.AdapterShopee
import com.radenmas.trendsmarketplace.databinding.ActivityShopeeBinding
import com.radenmas.trendsmarketplace.model.shopee.ItemsItem
import com.radenmas.trendsmarketplace.model.shopee.ResponseShopee
import com.radenmas.trendsmarketplace.network.Retro
import com.radenmas.trendsmarketplace.utils.Utils
import org.apache.poi.ss.usermodel.BorderStyle
import org.apache.poi.ss.usermodel.FillPatternType
import org.apache.poi.ss.usermodel.HorizontalAlignment
import org.apache.poi.ss.usermodel.IndexedColors
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.io.FileOutputStream
import java.io.IOException


class ShopeeActivity : AppCompatActivity() {

    private lateinit var b: ActivityShopeeBinding
    private lateinit var adapter: AdapterShopee
    lateinit var items: List<ItemsItem>
    var search: String = "produk terlaris"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        b = ActivityShopeeBinding.inflate(layoutInflater)
        setContentView(b.root)

        intiView()
        onClick()
    }

    private fun onClick() {
        b.imgBack.setOnClickListener {
            onBackPressed()
        }

        b.etSearch.setOnEditorActionListener(object : OnEditorActionListener {
            override fun onEditorAction(p0: TextView?, p1: Int, p2: KeyEvent?): Boolean {
                search = b.etSearch.text.toString()
                if (search.isNotBlank() && p1 == EditorInfo.IME_ACTION_SEARCH) {
                    b.etSearch.clearFocus()
                    Utils.showLoading(this@ShopeeActivity)

                    Retro.shopee.getSearchKeyword(
                        "sales",
                        search,
                        50,
                        0,
                        "desc",
                        "search",
                        "PAGE_GLOBAL_SEARCH",
                        2
                    )
                        .enqueue(object : Callback<ResponseShopee> {
                            override fun onResponse(
                                call: Call<ResponseShopee>,
                                response: Response<ResponseShopee>
                            ) {
                                Utils.dismissLoading()
                                items = response.body()?.items!!
                                for (c in items) {
                                    adapter.setProduct(items)
                                }
                            }

                            override fun onFailure(call: Call<ResponseShopee>, t: Throwable) {
                                Log.d("XXX", "ERROR : ${t.message}")
                            }
                        })

                    return true
                }
                return false
            }
        })

        b.imgDownload.setOnClickListener {
            Utils.showLoading(this@ShopeeActivity)
            createXlsx(search, items)
        }
    }

    private fun intiView() {
        Utils.showLoading(this@ShopeeActivity)

        Retro.shopee.getSearchKeyword(
            "sales",
            search,
            50,
            0,
            "desc",
            "search",
            "PAGE_GLOBAL_SEARCH",
            2
        )
            .enqueue(object : Callback<ResponseShopee> {
                override fun onResponse(
                    call: Call<ResponseShopee>,
                    response: Response<ResponseShopee>
                ) {
                    Utils.dismissLoading()
                    items = response.body()?.items!!
                    for (c in items) {
                        adapter.setProduct(items)
                    }
                }

                override fun onFailure(call: Call<ResponseShopee>, t: Throwable) {
                    Log.d("XXX", "ERROR : ${t.message}")
                }
            })

        b.rvProduct.layoutManager = GridLayoutManager(this@ShopeeActivity, 2)
        adapter = AdapterShopee(this)
        b.rvProduct.adapter = adapter
    }

    private fun createXlsx(name: String, items: List<ItemsItem>) {
        try {
            val root = File(
                Environment
                    .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "FileExcel"
            )
            if (!root.exists()) root.mkdirs()
            val path = File(root, "/${name}_shopee.xlsx")
            val workbook = XSSFWorkbook()
            val outputStream = FileOutputStream(path)
            val headerStyle = workbook.createCellStyle()
            headerStyle.setAlignment(HorizontalAlignment.CENTER)
            headerStyle.fillForegroundColor = IndexedColors.BLUE_GREY.getIndex()
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND)
            headerStyle.setBorderTop(BorderStyle.MEDIUM)
            headerStyle.setBorderBottom(BorderStyle.MEDIUM)
            headerStyle.setBorderRight(BorderStyle.MEDIUM)
            headerStyle.setBorderLeft(BorderStyle.MEDIUM)
            val font = workbook.createFont()
            font.fontHeightInPoints = 12.toShort()
            font.color = IndexedColors.WHITE.getIndex()
            font.bold = true
            headerStyle.setFont(font)
            val sheet = workbook.createSheet("Data Produk")
            var row = sheet.createRow(0)

            var cell = row.createCell(0)
            cell.setCellValue("Produk")
            cell.cellStyle = headerStyle

            cell = row.createCell(1)
            cell.setCellValue("Harga")
            cell.cellStyle = headerStyle

            cell = row.createCell(2)
            cell.setCellValue("Lokasi")
            cell.cellStyle = headerStyle

            cell = row.createCell(3)
            cell.setCellValue("Rating")
            cell.cellStyle = headerStyle

            cell = row.createCell(4)
            cell.setCellValue("Terjual")
            cell.cellStyle = headerStyle

            cell = row.createCell(5)
            cell.setCellValue("Link")
            cell.cellStyle = headerStyle

            cell = row.createCell(6)
            cell.setCellValue("Gambar")
            cell.cellStyle = headerStyle

            for (i in items.indices) {
                row = sheet.createRow(i + 1)

                cell = row.createCell(0)
                cell.setCellValue(items[i].itemBasic.name)

                cell = row.createCell(1)
                val price = items[i].itemBasic.price/100000
                cell.setCellValue(price.toString())

                cell = row.createCell(2)
                cell.setCellValue(items[i].itemBasic.shopLocation)

                cell = row.createCell(3)
                cell.setCellValue(Utils.formatComma1(items[i].itemBasic.itemRating.ratingStar.toFloat()))

                cell = row.createCell(4)
                cell.setCellValue(items[i].itemBasic.historicalSold.toString())

                cell = row.createCell(5)
                cell.setCellValue("https://www.shopee.co.id${items[i].itemBasic.name}.${items[i].itemBasic.shopid}.${items[i].itemBasic.itemid}")

                cell = row.createCell(6)
                cell.setCellValue("https://cf.shopee.co.id/file/${items[i].itemBasic.image}")
            }
            workbook.write(outputStream)
            outputStream.close()
            Utils.snack(b.root, "Data berhasil diekspor!")
            Utils.dismissLoading()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}