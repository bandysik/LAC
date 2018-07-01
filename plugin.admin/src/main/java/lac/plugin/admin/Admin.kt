package lac.plugin.admin

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

const val VERSION = "v1_0"
const val CITIES = VERSION + "/cities"
const val PROVIDERS = VERSION + "/providers"
const val FEEDS = VERSION + "/feeds"

object Admin {

    fun addToDb(path: String, value: Any) {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference(path)

        myRef.setValue(value)
    }

    fun pushToDb(path: String): DatabaseReference {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference(path)

        return myRef.push()
    }

    fun pushToDb(path: String, key: String): DatabaseReference {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference(path)

        return myRef.child(key)
    }

    fun addCity(code: String, name: String) {
        val city = City(code, name)
        pushToDb(CITIES, code).setValue(city)
    }

    fun addProvider(id: String, name: String) {
        val provider = Provider(id, name)
        pushToDb(PROVIDERS, id).setValue(provider)
    }

    fun addFeed(city: String,
                description: String,
                provider: String,
                providerLink: String,
                created: String) {
        val ref = pushToDb(FEEDS)
        val feed = Feed(ref.key!!, city, description, provider, providerLink, created)
        ref.setValue(feed)
    }
}