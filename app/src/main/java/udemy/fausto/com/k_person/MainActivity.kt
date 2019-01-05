package udemy.fausto.com.k_person

// https://www.codewars.com/kata/train-your-skills-in-writing-slash-reading-from-files-while-using-classes/train/cpp

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.io.*

class Person {}

class Worker {}



class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("--------->")

        //Destination File
        val file = "belchers.burgers"
        val fileAbstract = File(applicationContext.filesDir,file)

        //A map of family
        val family = mapOf(
            "Bob" to "Father",
            "Linda" to "Mother",
            "Tina" to "Oldest",
            "Gene" to "Middle",
            "Louise" to "Youngest")

        //Write the family map object to a file
        ObjectOutputStream(FileOutputStream(fileAbstract)).use{ it -> it.writeObject(family)}
        println("Wrote $fileAbstract")


        //Now time to read the family back into memory
        ObjectInputStream(FileInputStream(fileAbstract)).use { it ->
            //Read the family back from the file
            val restedFamily = it.readObject()

            //Cast it back into a Map
            when (restedFamily) {
                //We can't use <String, String> because of type erasure
                is Map<*, *> -> println(restedFamily)
                else -> println("Deserialization failed")
            }
            
          }


    }
}

class FileHelper (val file: String, val contentMap: Map<String, String> ,val context: Context) {

    fun write() {


    }
    fun read() {


    }


}
