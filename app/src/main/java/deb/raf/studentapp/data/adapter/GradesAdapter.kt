package deb.raf.studentapp.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import deb.raf.studentapp.data.model.StudentDiary
import deb.raf.studentapp.databinding.ItemStudentDiaryBinding

class GradesAdapter(val listStudentDiary: List<StudentDiary>?)  : RecyclerView.Adapter<GradesAdapter.ViewHolder>() {

    lateinit var binding : ItemStudentDiaryBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context.applicationContext)
        binding = ItemStudentDiaryBinding.inflate(layoutInflater)

        return ViewHolder(binding.root)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(
            binding,
            listStudentDiary!![position]
        )
    }

    override fun getItemCount(): Int = listStudentDiary!!.size


    class ViewHolder(
        view : View
    ) : RecyclerView.ViewHolder(view){
        fun bind(
            binding : ItemStudentDiaryBinding,
            item : StudentDiary
        ){
            binding.subjectValue.text = item.subject
            binding.gradeValue.text = item.grade
        }
    }
}