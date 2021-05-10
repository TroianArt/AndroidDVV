package com.example.androiddvv.data
import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey


// - Entity class for note table
// - A Parcelable is the Android implementation of the Java Serializable
// - It is used to transfer data between activities or fragments

@Entity(tableName = "notes")
class Note(@PrimaryKey(autoGenerate = true)
           var id: Long,
           var title: String?,
           var description: String?,
           var tag:String?) :Parcelable{


    constructor(parcel: Parcel) : this(
            parcel.readLong(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString())


    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeString(tag)
    }


    companion object CREATOR : Parcelable.Creator<Note> {
        override fun createFromParcel(parcel: Parcel): Note {
            return Note(parcel)
        }

        override fun newArray(size: Int): Array<Note?> {
            return arrayOfNulls(size)
        }
    }

    override fun hashCode(): Int {
        return id.hashCode() + title.hashCode() + description.hashCode() + tag.hashCode()
    }

}