package com.radenmas.trendsmarketplace.ui.blibli

import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.TextView.OnEditorActionListener
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.radenmas.trendsmarketplace.adapter.AdapterBlibli
import com.radenmas.trendsmarketplace.databinding.ActivityBlibliBinding
import com.radenmas.trendsmarketplace.model.blibli.ProductsItem
import com.radenmas.trendsmarketplace.model.blibli.ResponseBlibli
import com.radenmas.trendsmarketplace.network.Retro
import com.radenmas.trendsmarketplace.utils.Utils
import org.apache.poi.ss.usermodel.BorderStyle
import org.apache.poi.ss.usermodel.FillPatternType
import org.apache.poi.ss.usermodel.HorizontalAlignment
import org.apache.poi.ss.usermodel.IndexedColors
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import retrofit2.Call
import retrofit2.Callback
import java.io.File
import java.io.FileOutputStream
import java.io.IOException


class BlibliActivity : AppCompatActivity() {

    private lateinit var b: ActivityBlibliBinding
    private lateinit var adapter: AdapterBlibli
    lateinit var items: List<ProductsItem>
    var search: String = "produk terlaris"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        b = ActivityBlibliBinding.inflate(layoutInflater)
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
                    Utils.showLoading(this@BlibliActivity)

                    Retro.blibli.getSearchKeyword(16, 1, search)
                        .enqueue(object : Callback<ResponseBlibli> {
                            override fun onResponse(
                                call: Call<ResponseBlibli>,
                                response: retrofit2.Response<ResponseBlibli>
                            ) {
                                items = response.body()!!.data.products
                                Utils.dismissLoading()

                                Log.d("XXX", items.toString())

                                for (c in items) {
                                    adapter.setProduct(items)
                                }
                            }

                            override fun onFailure(call: Call<ResponseBlibli>, t: Throwable) {
                                Log.d("XXX", "ERROR: ${t.message}")
                            }
                        })
                    return true
                }
                return false
            }
        })

        b.imgDownload.setOnClickListener {
            Utils.showLoading(this@BlibliActivity)
            createXlsx(search, items)
        }
    }

    private fun intiView() {
        Utils.showLoading(this@BlibliActivity)

        Retro.blibli.getSearchKeyword(16, 1, search)
            .enqueue(object : Callback<ResponseBlibli> {
                override fun onResponse(
                    call: Call<ResponseBlibli>,
                    response: retrofit2.Response<ResponseBlibli>
                ) {
                    Utils.dismissLoading()
                    items = response.body()!!.data.products
                    for (c in items) {
                        adapter.setProduct(items)
                    }
                }

                override fun onFailure(call: Call<ResponseBlibli>, t: Throwable) {
                    Log.d("XXX", "ERROR: ${t.message}")
                }
            })

        b.rvProduct.layoutManager = LinearLayoutManager(this)
        adapter = AdapterBlibli(this)
        b.rvProduct.adapter = adapter
    }

    private fun createXlsx(name: String, items: List<ProductsItem>) {
        try {
            val root = File(
                Environment
                    .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "FileExcel"
            )
            if (!root.exists()) root.mkdirs()
            val path = File(root, "/${name}_blibli.xlsx")
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

            cell = row.createCell(7)
            cell.setCellValue("Deskripsi")
            cell.cellStyle = headerStyle

            for (i in items.indices) {
                row = sheet.createRow(i + 1)

                cell = row.createCell(0)
                cell.setCellValue(items[i].name)

                cell = row.createCell(1)
                cell.setCellValue(items[i].price.minPrice.toString())

                cell = row.createCell(2)
                cell.setCellValue(items[i].location)

                cell = row.createCell(3)
                cell.setCellValue(items[i].review.absoluteRating)

                cell = row.createCell(4)
                cell.setCellValue(items[i].soldRangeCount.id)

                cell = row.createCell(5)
                cell.setCellValue("https://www.blibli.com${items[i].url}")

                cell = row.createCell(6)
                cell.setCellValue(items[i].images[0])

                cell = row.createCell(7)
                cell.setCellValue(items[i].uniqueSellingPoint)
            }
            workbook.write(outputStream)
            outputStream.close()
            Utils.snack(b.root, "Data berhasil diekspor!")
            Utils.dismissLoading()
        } catch (e: IOException) {
            e.printStackTrace()
            Utils.dismissLoading()
        }
    }
}