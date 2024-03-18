package com.example.studentdatabase

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.studentdatabase.Data.StudentData


class rcadaptor( var context: Activity): RecyclerView.Adapter<rcadaptor.StudentViewHolder>() {
    private val studentList = mutableListOf<StudentData>()

//    class Studentviewholder(private val view: View) : RecyclerView.ViewHolder(view) {
//        //val rcimage = view.findViewById<ImageView>(R.id.rcprofile)
//        val rcname = view.findViewById<TextView>(R.id.rcname)
//
//    }
    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nameTextView: TextView = itemView.findViewById(R.id.rcname)
        //val ageTextView: TextView = itemView.findViewById(R.id.student_age_text)
       // val rollNoTextView: TextView = itemView.findViewById(R.id.student_roll_no_text)
       // val emailTextView: TextView = itemView.findViewById(R.id.student_email_text)
    // Update ImageView reference if needed for profile image
        val profileImageView: ImageView = itemView.findViewById(R.id.rcprofile)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val itemview=LayoutInflater.from(parent.context).inflate(R.layout.activity_listitemview,parent,false)
        return StudentViewHolder(itemview)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
       //var name=datalist[position]
        //holder.rcimage.setImageResource()

        //holder.rcname.text=name

        val student = studentList[position]
        holder.nameTextView.text = student.name
        Glide.with(context).load(student.profileImage).into(holder.profileImageView)
        //holder.ageTextView.text = student.age
        //holder.rollNoTextView.text = student.rollNo.toString()
       // holder.emailTextView.text = student.emailId
        // Update profile image if needed (assuming you have an ImageView in your layout)
         //holder.profileImageView.setImageResource(student.profileImage)
    }
    fun updateStudentList(newList: List<StudentData>) {
        studentList.clear()
        studentList.addAll(newList)
        notifyDataSetChanged()
    }
}