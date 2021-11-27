package com.example.cryptoinvestcenter.ui.view.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptoinvestcenter.R
import com.example.cryptoinvestcenter.data.db.config.CryptoMonedasApp.Companion.prefs
import com.example.cryptoinvestcenter.databinding.FragmentCryptoMonedasBinding
import com.example.cryptoinvestcenter.ui.view.adapters.MonedaAdapter
import com.example.cryptoinvestcenter.ui.view.interfaces.IComunicateMoneda
import com.example.cryptoinvestcenter.ui.viewModel.CryptoMonedaViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CryptoMonedasFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CryptoMonedasFragment : Fragment() {
    private var _binding: FragmentCryptoMonedasBinding?=null
    private  val binding get() = _binding!!

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var activity: Activity
    //lateinit var viewAux:View
    lateinit var iComunicateMoneda: IComunicateMoneda
    private lateinit var monedaViewModel: CryptoMonedaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCryptoMonedasBinding.inflate(inflater, container, false)
        this.monedaViewModel = ViewModelProvider(this).get(CryptoMonedaViewModel::class.java)
        initRecyclerView()
        return binding.root
        //return inflater.inflate(R.layout.fragment_crypto_monedas, container, false)
    }

    private fun initRecyclerView()
    {
        this.monedaViewModel.monedas.observe(viewLifecycleOwner, Observer {
            val adapter = MonedaAdapter(it, requireContext())
            binding.recyclerMonedas.layoutManager = LinearLayoutManager(requireContext())
            binding.recyclerMonedas.adapter=adapter
            adapter.setOnClickListener(object : View.OnClickListener{
                override fun onClick(v: View?) {
                    var idMoneda: String = it.get(binding.recyclerMonedas.getChildAdapterPosition(v!!)).id
                    prefs.idMoneda = idMoneda
                    iComunicateMoneda.viewDetailMoneda()
                }
            })
        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = context as Activity
        iComunicateMoneda = activity as IComunicateMoneda
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CryptoMonedasFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CryptoMonedasFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}