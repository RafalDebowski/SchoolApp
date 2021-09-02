package deb.raf.studentapp.data.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import deb.raf.studentapp.data.model.User
import deb.raf.studentapp.databinding.ElementListStudentsBinding
import deb.raf.studentapp.ui.studentsList.AddGradesActivity
import deb.raf.studentapp.ui.studentsList.ShowGradesActivity

class UsersListAdapter(
    val studentsList: List<User>?,
    val onClickAddButton: (intent: Intent) -> Unit ,
    val onClickShowButton: (intent: Intent) -> Unit
) : RecyclerView.Adapter<UsersListAdapter.ViewHolder>() {

    lateinit var binding: ElementListStudentsBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context.applicationContext)
        binding = ElementListStudentsBinding.inflate(layoutInflater)

        return ViewHolder(binding.root)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(
            binding,
            studentsList!![position],
            binding.root,
            onClickAddButton,
            onClickShowButton
        )
    }

    override fun getItemCount(): Int = studentsList!!.size

    class ViewHolder(
        view: View
    ) : RecyclerView.ViewHolder(view) {
        fun bind(
            binding: ElementListStudentsBinding,
            item: User,
            view: View,
            onClickAddButton: (intent: Intent) -> Unit,
            onClickShowButton: (intent: Intent) -> Unit
        ) {
            binding.name.text = item.name
            binding.surname.text = item.surname

            binding.addButton.setOnClickListener {
                val intent = Intent(view.context , AddGradesActivity::class.java )
                intent.putExtra("SURNAME", binding.surname.text)
                intent.putExtra("NAME", binding.name.text)
                onClickAddButton(intent)
            }

            binding.showButton.setOnClickListener {
                val intent = Intent(view.context , ShowGradesActivity::class.java )
                intent.putExtra("SURNAME", binding.surname.text)
                intent.putExtra("NAME", binding.name.text)
                onClickShowButton(intent)
            }
        }

    }
}