package com.example.product.data

    import com.example.product.R
    import com.example.product.model.Product

    class DataSource {
        fun loadProducts(): List<Product> {
            return listOf(
                Product(R.string.productName1, R.string.productPrice1, true, 5, R.drawable.iphone12, R.string.url1)
                ,Product(R.string.productName2, R.string.productPrice2, false, 5, R.drawable.samsung_galaxy_uitra, R.string.url2)
                ,Product(R.string.productName3, R.string.productPrice3, true, 0, R.drawable.xiaomi_pro, R.string.url3)
                ,Product(R.string.productName4, R.string.productPrice4, false, 0, R.drawable.huawei_yp, R.string.url4)
                ,Product(R.string.productName5, R.string.productPrice5, true, 70, R.drawable.samsung_galaxy_z_flip, R.string.url5)
                ,Product(R.string.productName6, R.string.productPrice6, true, 36, R.drawable.iphone13, R.string.url6)
            )
        }



    }
