package com.example.product

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.product.adapter.ItemAdapter
import com.example.product.data.DataSource
import com.example.product.databinding.FragmentProductListBinding



class ProductListFragment : Fragment() {
    var binding: FragmentProductListBinding? = null

    private lateinit var recyclerView: RecyclerView
    var isLinearList = true
    val myData = DataSource().loadProducts()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProductListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding!!.recyclerView
        //set layout linear
        setLayoutManager()
        // To handle back system
        requireActivity().onBackPressedDispatcher.addCallback {
            Toast.makeText(requireContext(), "This is first page", Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    fun setLayoutManager() {
        if (isLinearList) {
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
        } else {
            recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        }
        recyclerView.adapter = ItemAdapter(myData, requireContext())
        recyclerView.setHasFixedSize(true)
    }

    fun setMenuIcon(item: MenuItem) {
        if (isLinearList) {
            item.setIcon(R.drawable.ic_baseline_view_list_24)
        } else {
            item.setIcon(R.drawable.ic_baseline_grid_on_24)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.linear_list) {
            isLinearList = !isLinearList
            setLayoutManager()
            setMenuIcon(item)
        }
        return true
    }



}