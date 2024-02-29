package com.example.soullive

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.soullive.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSearchBinding.inflate(inflater, container, false)

        initRecycler()

        return binding.root
    }

    private fun initRecycler(){
        val modelList = mutableListOf<FavoriteModelItem>()

        modelList.add(FavoriteModelItem(R.drawable.fav1))
        modelList.add(FavoriteModelItem(R.drawable.fav2))
        modelList.add(FavoriteModelItem(R.drawable.fav3))

        val rvAdapter = SearchRVAdapter(modelList)

        binding.recentFavoriteModelRv.adapter = rvAdapter

        binding.recentFavoriteModelRv.layoutManager = LinearLayoutManager(context).also {
            it.orientation = LinearLayoutManager.HORIZONTAL
        }
    }
}