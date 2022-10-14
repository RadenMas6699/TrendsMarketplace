package com.radenmas.trendsmarketplace.ui.tokopedia

import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.TextView.OnEditorActionListener
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.radenmas.trendsmarketplace.adapter.AdapterTokopedia
import com.radenmas.trendsmarketplace.databinding.ActivityTokopediaBinding
import com.radenmas.trendsmarketplace.model.tokopedia.ProductsItem
import com.radenmas.trendsmarketplace.model.tokopedia.ResponseTokopedia
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


class TokopediaActivity : AppCompatActivity() {

    private lateinit var b: ActivityTokopediaBinding
    private lateinit var adapter: AdapterTokopedia
    lateinit var items: List<ProductsItem>
    var search: String = "produk terlaris"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        b = ActivityTokopediaBinding.inflate(layoutInflater)
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
                search = b.etSearch.text.toString().trim()
                if (search.isNotBlank() && p1 == EditorInfo.IME_ACTION_SEARCH) {
                    b.etSearch.clearFocus()
                    Utils.showLoading(this@TokopediaActivity)

                    val raw =
                        "{\"operationName\":\"DynamicSearchProductQuery\",\"variables\":{\"includeAds\":true,\"params\":\"topads_bucket=true&ob=23&device=mobile&source=universe&page=1&use_page=true&related=true&q=$search&user_id=0&safe_search=false&unique_id=2c458a1bc3a31cd0cac895c90b687b68&navsource=home&st=product&srp_component_id=01.02.01.01&user_addressId=&user_cityId=176&user_districtId=2274&user_lat=&user_long=&user_postCode=&user_warehouseId=12210375\",\"adParams\":\"ob=23&ep=product&src=search&page=1&device=mobile&with_template=true&q=$search&dep_id=&source=universe&st=product&navsource=home&srp_component_id=01.02.01.01&user_addressId=&user_cityId=176&user_districtId=2274&user_lat=&user_long=&user_postCode=&user_warehouseId=12210375\"},\"query\":\"query DynamicSearchProductQuery(\$params: String!, \$adParams: String, \$includeAds: Boolean = true) {\\n  organic: ace_search_product_v4(params: \$params) {\\n    header {\\n      additionalParams\\n      componentId\\n      defaultView\\n      errorMessage\\n      keywordProcess\\n      responseCode\\n      totalData\\n      totalDataText\\n      __typename\\n    }\\n    data {\\n      banner {\\n        position\\n        text\\n        imageUrl\\n        url\\n        __typename\\n      }\\n      backendFilters\\n      isQuerySafe\\n      products {\\n        id\\n        name\\n        ads {\\n          adsId: id\\n          productClickUrl\\n          productWishlistUrl\\n          productViewUrl\\n          tag\\n          __typename\\n        }\\n        categoryId\\n        categoryName\\n        childs\\n        countReview\\n        discountPercentage\\n        gaKey\\n        imageUrl\\n        customVideoURL\\n        labelGroups {\\n          position\\n          title\\n          type\\n          url\\n          __typename\\n        }\\n        labelGroupVariant {\\n          title\\n          type\\n          typeVariant: type_variant\\n          hexColor: hex_color\\n          __typename\\n        }\\n        minOrder\\n        originalPrice\\n        price\\n        rating\\n        ratingAverage\\n        shop {\\n          id\\n          name\\n          url\\n          city\\n          isOfficial\\n          isPowerBadge\\n          __typename\\n        }\\n        badges {\\n          title\\n          imageUrl\\n          show\\n          __typename\\n        }\\n        url\\n        warehouseID: warehouseIdDefault\\n        wishlist\\n        sourceEngine: source_engine\\n        __typename\\n      }\\n      redirection {\\n        redirectUrl\\n        departmentId\\n        __typename\\n      }\\n      related {\\n        position\\n        relatedKeyword\\n        trackingOption\\n        otherRelated {\\n          keyword\\n          url\\n          product {\\n            id\\n            name\\n            ads {\\n              adsId: id\\n              productClickUrl\\n              productViewUrl\\n              __typename\\n            }\\n            imageUrl\\n            rating\\n            countReview\\n            url\\n            priceStr\\n            shop {\\n              city\\n              isOfficial\\n              isPowerBadge\\n              name\\n              __typename\\n            }\\n            badges {\\n              title\\n              imageUrl\\n              show\\n              __typename\\n            }\\n            ratingAverage\\n            labelGroups {\\n              position\\n              type\\n              title\\n              url\\n              __typename\\n            }\\n            __typename\\n          }\\n          componentId\\n          __typename\\n        }\\n        __typename\\n      }\\n      suggestion {\\n        currentKeyword\\n        suggestion\\n        suggestionCount\\n        instead\\n        insteadCount\\n        text\\n        query\\n        componentId\\n        trackingOption\\n        __typename\\n      }\\n      ticker {\\n        text\\n        query\\n        typeId\\n        componentId\\n        trackingOption\\n        __typename\\n      }\\n      violation {\\n        headerText\\n        descriptionText\\n        imageUrl: imageURL\\n        ctaUrl: ctaURL\\n        buttonType\\n        buttonText\\n        __typename\\n      }\\n      __typename\\n    }\\n    __typename\\n  }\\n  topads: displayAdsV3(displayParams: \$adParams) @include(if: \$includeAds) {\\n    data {\\n      id\\n      ad_ref_key\\n      redirect\\n      sticker_id\\n      sticker_image\\n      clickTrackUrl: product_click_url\\n      shop_click_url\\n      product {\\n        id\\n        name\\n        wishlist\\n        image {\\n          s_ecs\\n          s_url\\n          __typename\\n        }\\n        url: uri\\n        relative_uri\\n        price: price_format\\n        campaign {\\n          original_price\\n          discount_percentage\\n          __typename\\n        }\\n        wholeSalePrice: wholesale_price {\\n          quantityMin: quantity_min_format\\n          quantityMax: quantity_max_format\\n          price: price_format\\n          __typename\\n        }\\n        countReview: count_review_format\\n        category {\\n          id\\n          __typename\\n        }\\n        minOrder: product_minimum_order\\n        product_wholesale\\n        free_return\\n        isNewProduct: product_new_label\\n        cashback: product_cashback_rate\\n        rating: product_rating\\n        ratingAverage: product_rating_format\\n        top_label\\n        labelGroups: label_group {\\n          position\\n          type\\n          title\\n          url\\n          __typename\\n        }\\n        categoryBreadcrumb: category_breadcrumb\\n        __typename\\n      }\\n      shop {\\n        id\\n        name\\n        city\\n        isPowerBadge: gold_shop\\n        gold_shop_badge\\n        isOfficial: shop_is_official\\n        url: uri\\n        owner_id\\n        is_owner\\n        badges {\\n          title\\n          imageUrl: image_url\\n          show\\n          __typename\\n        }\\n        __typename\\n      }\\n      applinks\\n      tag\\n      __typename\\n    }\\n    template {\\n      isAd: is_ad\\n      __typename\\n    }\\n    __typename\\n  }\\n  inspirationCarousel: searchInspirationCarouselV2(params: \$params) {\\n    data {\\n      title\\n      position\\n      type\\n      layout\\n      options {\\n        component_id\\n        title\\n        url\\n        product {\\n          id\\n          name\\n          price\\n          imageUrl: image_url\\n          rating\\n          countReview: count_review\\n          url\\n          applink\\n          priceStr: price_str\\n          description\\n          shop {\\n            name\\n            city\\n            __typename\\n          }\\n          badges {\\n            title\\n            imageUrl: image_url\\n            show\\n            __typename\\n          }\\n          wishlist\\n          freeOngkir {\\n            isActive\\n            imageUrl: image_url\\n            __typename\\n          }\\n          ratingAverage: rating_average\\n          labelGroups: label_groups {\\n            position\\n            title\\n            type\\n            url\\n            __typename\\n          }\\n          ads {\\n            adsId: id\\n            productClickUrl\\n            productWishlistUrl\\n            shopClickUrl\\n            productViewUrl\\n            __typename\\n          }\\n          __typename\\n        }\\n        __typename\\n      }\\n      tracking_option\\n      __typename\\n    }\\n    __typename\\n  }\\n}\\n\"}"

                    Retro.tokopedia.searchProductTokopedia(raw)
                        .enqueue(object : Callback<ResponseTokopedia> {
                            override fun onResponse(
                                call: Call<ResponseTokopedia>,
                                response: retrofit2.Response<ResponseTokopedia>
                            ) {
                                Utils.dismissLoading()
                                items = response.body()!!.data.organic.data.products
                                for (c in items) {
                                    adapter.setProduct(items)
                                }
                            }

                            override fun onFailure(call: Call<ResponseTokopedia>, t: Throwable) {
                                Utils.dismissLoading()
                                Log.d("XXX", "ERROR: ${t.message}")
                            }
                        })

                    return true
                }
                return false
            }
        })

        b.imgDownload.setOnClickListener {
            Utils.showLoading(this@TokopediaActivity)
            createXlsx(search, items)
        }
    }

    private fun intiView() {
        Utils.showLoading(this@TokopediaActivity)

        val raw =
            "{\"operationName\":\"DynamicSearchProductQuery\",\"variables\":{\"includeAds\":true,\"params\":\"topads_bucket=true&ob=23&device=mobile&source=universe&page=1&use_page=true&related=true&q=$search&user_id=0&safe_search=false&unique_id=2c458a1bc3a31cd0cac895c90b687b68&navsource=home&st=product&srp_component_id=01.02.01.01&user_addressId=&user_cityId=176&user_districtId=2274&user_lat=&user_long=&user_postCode=&user_warehouseId=12210375\",\"adParams\":\"ob=23&ep=product&src=search&page=1&device=mobile&with_template=true&q=$search&dep_id=&source=universe&st=product&navsource=home&srp_component_id=01.02.01.01&user_addressId=&user_cityId=176&user_districtId=2274&user_lat=&user_long=&user_postCode=&user_warehouseId=12210375\"},\"query\":\"query DynamicSearchProductQuery(\$params: String!, \$adParams: String, \$includeAds: Boolean = true) {\\n  organic: ace_search_product_v4(params: \$params) {\\n    header {\\n      additionalParams\\n      componentId\\n      defaultView\\n      errorMessage\\n      keywordProcess\\n      responseCode\\n      totalData\\n      totalDataText\\n      __typename\\n    }\\n    data {\\n      banner {\\n        position\\n        text\\n        imageUrl\\n        url\\n        __typename\\n      }\\n      backendFilters\\n      isQuerySafe\\n      products {\\n        id\\n        name\\n        ads {\\n          adsId: id\\n          productClickUrl\\n          productWishlistUrl\\n          productViewUrl\\n          tag\\n          __typename\\n        }\\n        categoryId\\n        categoryName\\n        childs\\n        countReview\\n        discountPercentage\\n        gaKey\\n        imageUrl\\n        customVideoURL\\n        labelGroups {\\n          position\\n          title\\n          type\\n          url\\n          __typename\\n        }\\n        labelGroupVariant {\\n          title\\n          type\\n          typeVariant: type_variant\\n          hexColor: hex_color\\n          __typename\\n        }\\n        minOrder\\n        originalPrice\\n        price\\n        rating\\n        ratingAverage\\n        shop {\\n          id\\n          name\\n          url\\n          city\\n          isOfficial\\n          isPowerBadge\\n          __typename\\n        }\\n        badges {\\n          title\\n          imageUrl\\n          show\\n          __typename\\n        }\\n        url\\n        warehouseID: warehouseIdDefault\\n        wishlist\\n        sourceEngine: source_engine\\n        __typename\\n      }\\n      redirection {\\n        redirectUrl\\n        departmentId\\n        __typename\\n      }\\n      related {\\n        position\\n        relatedKeyword\\n        trackingOption\\n        otherRelated {\\n          keyword\\n          url\\n          product {\\n            id\\n            name\\n            ads {\\n              adsId: id\\n              productClickUrl\\n              productViewUrl\\n              __typename\\n            }\\n            imageUrl\\n            rating\\n            countReview\\n            url\\n            priceStr\\n            shop {\\n              city\\n              isOfficial\\n              isPowerBadge\\n              name\\n              __typename\\n            }\\n            badges {\\n              title\\n              imageUrl\\n              show\\n              __typename\\n            }\\n            ratingAverage\\n            labelGroups {\\n              position\\n              type\\n              title\\n              url\\n              __typename\\n            }\\n            __typename\\n          }\\n          componentId\\n          __typename\\n        }\\n        __typename\\n      }\\n      suggestion {\\n        currentKeyword\\n        suggestion\\n        suggestionCount\\n        instead\\n        insteadCount\\n        text\\n        query\\n        componentId\\n        trackingOption\\n        __typename\\n      }\\n      ticker {\\n        text\\n        query\\n        typeId\\n        componentId\\n        trackingOption\\n        __typename\\n      }\\n      violation {\\n        headerText\\n        descriptionText\\n        imageUrl: imageURL\\n        ctaUrl: ctaURL\\n        buttonType\\n        buttonText\\n        __typename\\n      }\\n      __typename\\n    }\\n    __typename\\n  }\\n  topads: displayAdsV3(displayParams: \$adParams) @include(if: \$includeAds) {\\n    data {\\n      id\\n      ad_ref_key\\n      redirect\\n      sticker_id\\n      sticker_image\\n      clickTrackUrl: product_click_url\\n      shop_click_url\\n      product {\\n        id\\n        name\\n        wishlist\\n        image {\\n          s_ecs\\n          s_url\\n          __typename\\n        }\\n        url: uri\\n        relative_uri\\n        price: price_format\\n        campaign {\\n          original_price\\n          discount_percentage\\n          __typename\\n        }\\n        wholeSalePrice: wholesale_price {\\n          quantityMin: quantity_min_format\\n          quantityMax: quantity_max_format\\n          price: price_format\\n          __typename\\n        }\\n        countReview: count_review_format\\n        category {\\n          id\\n          __typename\\n        }\\n        minOrder: product_minimum_order\\n        product_wholesale\\n        free_return\\n        isNewProduct: product_new_label\\n        cashback: product_cashback_rate\\n        rating: product_rating\\n        ratingAverage: product_rating_format\\n        top_label\\n        labelGroups: label_group {\\n          position\\n          type\\n          title\\n          url\\n          __typename\\n        }\\n        categoryBreadcrumb: category_breadcrumb\\n        __typename\\n      }\\n      shop {\\n        id\\n        name\\n        city\\n        isPowerBadge: gold_shop\\n        gold_shop_badge\\n        isOfficial: shop_is_official\\n        url: uri\\n        owner_id\\n        is_owner\\n        badges {\\n          title\\n          imageUrl: image_url\\n          show\\n          __typename\\n        }\\n        __typename\\n      }\\n      applinks\\n      tag\\n      __typename\\n    }\\n    template {\\n      isAd: is_ad\\n      __typename\\n    }\\n    __typename\\n  }\\n  inspirationCarousel: searchInspirationCarouselV2(params: \$params) {\\n    data {\\n      title\\n      position\\n      type\\n      layout\\n      options {\\n        component_id\\n        title\\n        url\\n        product {\\n          id\\n          name\\n          price\\n          imageUrl: image_url\\n          rating\\n          countReview: count_review\\n          url\\n          applink\\n          priceStr: price_str\\n          description\\n          shop {\\n            name\\n            city\\n            __typename\\n          }\\n          badges {\\n            title\\n            imageUrl: image_url\\n            show\\n            __typename\\n          }\\n          wishlist\\n          freeOngkir {\\n            isActive\\n            imageUrl: image_url\\n            __typename\\n          }\\n          ratingAverage: rating_average\\n          labelGroups: label_groups {\\n            position\\n            title\\n            type\\n            url\\n            __typename\\n          }\\n          ads {\\n            adsId: id\\n            productClickUrl\\n            productWishlistUrl\\n            shopClickUrl\\n            productViewUrl\\n            __typename\\n          }\\n          __typename\\n        }\\n        __typename\\n      }\\n      tracking_option\\n      __typename\\n    }\\n    __typename\\n  }\\n}\\n\"}"

        Retro.tokopedia.searchProductTokopedia(raw)
            .enqueue(object : Callback<ResponseTokopedia> {
                override fun onResponse(
                    call: Call<ResponseTokopedia>,
                    response: retrofit2.Response<ResponseTokopedia>
                ) {
                    Utils.dismissLoading()
                    items = response.body()!!.data.organic.data.products
                    for (c in items) {
                        adapter.setProduct(items)
                    }
                }

                override fun onFailure(call: Call<ResponseTokopedia>, t: Throwable) {
                    Utils.dismissLoading()
                    Log.d("XXX", "ERROR: ${t.message}")
                }
            })

        b.rvProduct.layoutManager = GridLayoutManager(this@TokopediaActivity, 2)
        adapter = AdapterTokopedia(this)
        b.rvProduct.adapter = adapter
//       b.rvProduct.addOnScrollListener(object :OnScrollChangeListener{})
    }

    private fun createXlsx(name: String, items: List<ProductsItem>) {
        try {
            val root = File(
                Environment
                    .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "FileExcel"
            )
            if (!root.exists()) root.mkdirs()
            val path = File(root, "/${name}_tokopedia.xlsx")
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
                cell.setCellValue(items[i].name)

                cell = row.createCell(1)
                cell.setCellValue(items[i].price)

                cell = row.createCell(2)
                cell.setCellValue(items[i].shop.city)

                cell = row.createCell(3)
                cell.setCellValue(items[i].ratingAverage)

                cell = row.createCell(4)
                cell.setCellValue(items[i].labelGroups.toString())

                cell = row.createCell(5)
                cell.setCellValue(items[i].url)

                cell = row.createCell(6)
                cell.setCellValue(items[i].imageUrl)
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