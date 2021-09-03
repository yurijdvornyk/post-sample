package com.example.postdetailssample.view.postlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.postdetailssample.databinding.ItemPostBinding
import com.example.postdetailssample.model.SamplePost

class PostsAdapter(private val onPostSelected: (postId: Int) -> Unit) :
    RecyclerView.Adapter<PostItemViewHolder>() {

    var items: List<SamplePost> = listOf()
        set(value) {
            notifyDataSetChanged()
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPostBinding.inflate(inflater, parent, false)
        return PostItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostItemViewHolder, position: Int) {
        holder.bind(items[position], onPostSelected)
    }

    override fun getItemCount() = items.size
}

class PostItemViewHolder(private val viewBinding: ItemPostBinding) :
    RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(post: SamplePost, onPostSelected: (postId: Int) -> Unit) {
        viewBinding.postTitleText.text = post.title
        viewBinding.itemLayout.setOnClickListener {
            onPostSelected(post.id)
        }
    }
}