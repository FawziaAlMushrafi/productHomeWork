package com.example.product

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import com.example.product.databinding.FragmentBuyMobileBinding


class BuyMobileFragment : Fragment() {
    var binding: FragmentBuyMobileBinding? = null

    lateinit var imageResourceInt: String
    lateinit var productName: String
    lateinit var productPrice: String
    lateinit var productUrl: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            imageResourceInt = it.getString(IMAGERESOURCE).toString()
            productName = it.getString(PRODUCTNAME).toString()
            productPrice = it.getString(PRODUCTPRICE).toString()
            productUrl = it.getString(PRODUCTURL).toString()
        }
        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBuyMobileBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding!!.productImage.setImageResource(imageResourceInt.toInt())
        binding!!.productName.setText(productName)
        binding!!.productPrice.setText(productPrice)
        binding!!.moreInfoLink.setOnClickListener {
            gotoUrl(productUrl)
        }
        // To handle back system
        requireActivity().onBackPressedDispatcher.addCallback {
            findNavController().navigateUp()
        }



    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }


    fun gotoUrl(str: String) {
        val uri = Uri.parse(str)
        startActivity(Intent(Intent.ACTION_VIEW, uri))
    }

    companion object {
        const val IMAGERESOURCE = "productImage"
        const val PRODUCTNAME = "productName"
        const val PRODUCTPRICE = "productPrice"
        const val PRODUCTURL = "ProducUrl"
    }
}
