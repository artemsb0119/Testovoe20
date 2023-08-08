package com.example.testovoe20

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.URL

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class TennisFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MatchAdapter

    private lateinit var match: List<Match>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_all, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        val verticalLayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = verticalLayoutManager
        loadData()
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TennisFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun loadData() {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val data = URL("http://135.181.248.237/20/tennis.json").readText()
                val gson = Gson()
                match = gson.fromJson(data, Array<Match>::class.java).toList()

                requireActivity().runOnUiThread {
                    adapter = MatchAdapter(requireContext(), match)
                    recyclerView.adapter = adapter
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}