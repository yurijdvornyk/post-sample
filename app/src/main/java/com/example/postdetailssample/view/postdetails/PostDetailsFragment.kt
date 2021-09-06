package com.example.postdetailssample.view.postdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.postdetailssample.R
import com.example.postdetailssample.databinding.FragmentPostDetailsBinding
import com.example.postdetailssample.view.BaseFragment
import com.example.postdetailssample.viewmodel.PostDetailsViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostDetailsFragment : BaseFragment<PostDetailsViewModel>() {

    private lateinit var viewBinding: FragmentPostDetailsBinding

    override val viewModel: PostDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentPostDetailsBinding.inflate(inflater, container, false)
        viewModel.initialize(arguments?.getInt(ARG_POST_ID))
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.loader.visibility = View.VISIBLE
        setUpDataObservers()
        setUpListeners()
        loadData()
    }

    override fun retry() {
        super.retry()
        loadData()
    }

    override fun showNoData() {
        super.showNoData()
        viewBinding.loader.visibility = View.GONE
        viewBinding.noContentText.visibility = View.VISIBLE
        viewBinding.postTitleText.visibility = View.GONE
        viewBinding.postBodyText.visibility = View.GONE
        viewBinding.refreshLayout.isRefreshing = false
    }

    private fun setUpDataObservers() {
        viewModel.userData.observe(viewLifecycleOwner) {
            viewBinding.usernameText.text = it.name
            Picasso.get()
                .load("https://source.unsplash.com/collection/542909/?sig=${it.id}")
                .placeholder(R.drawable.ic_user_placeholder)
                .into(viewBinding.profileImage)
        }
        viewModel.postData.observe(viewLifecycleOwner) {
            viewBinding.refreshLayout.isRefreshing = false
            viewBinding.loader.visibility = View.GONE
            viewBinding.noContentText.visibility = View.GONE
            it?.let { post ->
                viewBinding.postTitleText.text = post.title
                viewBinding.postBodyText.text = post.body
            }
        }
    }

    private fun setUpListeners() {
        viewBinding.refreshLayout.setOnRefreshListener {
            loadData()
        }
    }

    private fun loadData() {
        viewModel.loadData()
    }

    companion object {
        const val ARG_POST_ID = "arg_post_id"
    }
}