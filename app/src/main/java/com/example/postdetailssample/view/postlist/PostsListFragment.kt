package com.example.postdetailssample.view.postlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.postdetailssample.R
import com.example.postdetailssample.databinding.FragmentPostsListBinding
import com.example.postdetailssample.view.BaseFragment
import com.example.postdetailssample.view.postdetails.PostDetailsFragment
import com.example.postdetailssample.viewmodel.PostsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostsListFragment : BaseFragment<PostsViewModel>() {

    private lateinit var viewBinding: FragmentPostsListBinding

    override val viewModel: PostsViewModel by viewModels()

    private val postsAdapter = PostsAdapter {
        findNavController().navigate(
            R.id.action_list_to_details,
            bundleOf(PostDetailsFragment.ARG_POST_ID to it)
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentPostsListBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.loader.visibility = View.VISIBLE
        setUpPostsRecycler()
        setUpDataObserver()
        setUpListeners()
        loadData()
    }

    override fun showNoData() {
        viewBinding.loader.visibility = View.GONE
        viewBinding.postsRecycler.visibility = View.GONE
        viewBinding.noContentText.visibility = View.VISIBLE
    }

    override fun retry() {
        super.retry()
        loadData()
    }

    private fun setUpPostsRecycler() {
        viewBinding.postsRecycler.adapter = postsAdapter
        viewBinding.postsRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    private fun setUpListeners() {
        viewBinding.refreshLayout.setOnRefreshListener {
            val isLoading = viewBinding.loader.visibility == View.VISIBLE
            if (!isLoading) {
                loadData()
            }
        }
    }

    private fun setUpDataObserver() {
        viewModel.postsData.observe(viewLifecycleOwner) {
            viewBinding.loader.visibility = View.GONE
            viewBinding.postsRecycler.visibility = View.VISIBLE
            viewBinding.noContentText.visibility = View.GONE
            viewBinding.refreshLayout.isRefreshing = false
            it?.let { posts ->
                postsAdapter.items = posts
            }
        }
    }

    private fun loadData() {
        viewModel.loadPosts()
    }
}