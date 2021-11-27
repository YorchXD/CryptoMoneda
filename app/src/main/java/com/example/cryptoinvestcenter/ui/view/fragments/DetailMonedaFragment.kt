package com.example.cryptoinvestcenter.ui.view.fragments

import android.R.string
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoinvestcenter.data.db.config.CryptoMonedasApp.Companion.prefs
import com.example.cryptoinvestcenter.databinding.FragmentDetailMonedaBinding
import com.example.cryptoinvestcenter.ui.view.interfaces.IComunicateMoneda
import com.example.cryptoinvestcenter.ui.viewModel.CryptoMonedaViewModel
import com.squareup.picasso.Picasso
import java.time.LocalDate
import java.time.format.DateTimeFormatter


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailMonedaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailMonedaFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentDetailMonedaBinding?=null
    private  val binding get() = _binding!!

    lateinit var activity: Activity
    lateinit var iComunicateMoneda: IComunicateMoneda
    private lateinit var cryptoMonedaViewModel: CryptoMonedaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_detail_moneda, container, false)
        _binding = FragmentDetailMonedaBinding.inflate(inflater, container, false)
        this.cryptoMonedaViewModel = ViewModelProvider(this).get(CryptoMonedaViewModel::class.java)
        initDetailMonedaView()
        initSendEmail()
        inicializarBtnVolver()
        return binding.root
    }

    private fun initSendEmail()
    {
        binding.getInfo.setOnClickListener {
            //get input from EditTexts and save in variables
            val recipient = "Info@cryptoinvest.cl"
            val subject = "Solicito información sobre esta criptomoneda ID " + prefs.idMoneda
            val message = "Hola\n\n" +
                    "Quisiera pedir información sobre esta moneda " + binding.nameMoneda.text + ", me gustaría que me contactaran a este correo o al siguiente número _________\n\n" +
                    "Quedo atento."
            //method call for email intent with these inputs as parameters
            sendEmail(recipient, subject, message)
        }
    }

    private fun sendEmail(recipient: String, subject: String, message: String)
    {
        /*ACTION_SEND action to launch an email client installed on your Android device.*/
        val mIntent = Intent(Intent.ACTION_SEND)
        /*To send an email you need to specify mailto: as URI using setData() method
        and data type will be to text/plain using setType() method*/
        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "text/plain"
        // put recipient email in intent
        /* recipient is put as array because you may wanna send email to multiple emails
           so enter comma(,) separated emails, it will be stored in array*/
        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        //put the Subject in the intent
        mIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        //put the message in the intent
        mIntent.putExtra(Intent.EXTRA_TEXT, message)


        try {
            //start email intent
            startActivity(Intent.createChooser(mIntent, "Choose Email Client..."))
        }
        catch (e: Exception){
            //if any thing goes wrong for example no email client application or any exception
            //get and show exception message
            Toast.makeText(requireContext(), e.message, Toast.LENGTH_LONG).show()
        }

    }


    private fun inicializarBtnVolver()
    {
        binding.btnAtras.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                iComunicateMoneda.viewMonedas()
            }
        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = context as Activity
        iComunicateMoneda = activity as IComunicateMoneda
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun initDetailMonedaView()
    {
        this.cryptoMonedaViewModel.detailMoneda.observe(viewLifecycleOwner, Observer {
            binding.nameMoneda.setText(it.name)
            binding.symbolDetail.setText(it.symbol)
            binding.rank.setText(it.rank.toString())
            binding.status.setText(it.status)
            binding.price.setText(it.price.toString())
            val formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
            val date = LocalDate.parse(it.price_date, formatDate)
            binding.date.setText(date.toString())
            Picasso.get().load(it.logo_url).into(binding.itemIconDetail)

        })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DetailMonedaFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DetailMonedaFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}