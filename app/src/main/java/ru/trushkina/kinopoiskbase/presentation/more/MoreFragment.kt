package ru.trushkina.kinopoiskbase.presentation.more

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import ru.trushkina.kinopoiskbase.R
import ru.trushkina.kinopoiskbase.databinding.FragmentMoreBinding
import ru.trushkina.kinopoiskbase.presentation.utils.showBottomNav

class MoreFragment : Fragment() {

    private var _binding: FragmentMoreBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showBottomNav()

        with(binding) {
            toolbar.title = getString(R.string.title_more)
            itemViewCode.setOnClickListener { showSourceCode() }
            itemAbout.setOnClickListener { showAboutDialog() }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showSourceCode() =
        startActivity(Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(getString(R.string.url_project_github))
        })

    private fun showAboutDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(resources.getString(R.string.about_kinopoisk))
            .setMessage(resources.getString(R.string.about_kinopoisk_message))
            .setPositiveButton(resources.getString(android.R.string.ok)) { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}