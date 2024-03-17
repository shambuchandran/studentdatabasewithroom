//package com.example.studentdatabase
//
//import android.net.Uri
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.example.studentdatabase.Data.StudentData
//
//class rcadaptor():RecyclerView.Adapter<Studentviewholder>() {
//    private val studentDatalist=ArrayList<StudentData>()
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Studentviewholder {
//        val layoutInflater=LayoutInflater.from(parent.context)
//        val listitem=layoutInflater.inflate(R.layout.activity_listitemview,parent,false)
//        return Studentviewholder(listitem)
//    }
//
//    override fun getItemCount(): Int {
//        return studentDatalist.size
//    }
//
//    override fun onBindViewHolder(holder: Studentviewholder, position: Int) {
//       holder.bind(studentDatalist[position])
//    }
//    fun setlist(studentData:List<StudentData>){
//        studentDatalist.clear()
//        studentDatalist.addAll(studentData)
//
//    }
//
//}
//class Studentviewholder(private val view: View):RecyclerView.ViewHolder(view){
//    fun bind(studentData: StudentData){
//        val rcprofilepic=view.findViewById<ImageView>(R.id.rcprofile)
//        val rcname=view.findViewById<TextView>(R.id.rcname)
//        rcprofilepic.setImageURI(Uri.parse(studentData.profileImage.toString()))
//        rcname.text=studentData.name
//
//    }
//}