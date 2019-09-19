import com.google.gson.annotations.SerializedName

data class Records (
		@SerializedName("volume_of_mobile_data") val volume_of_mobile_data : Double,
		@SerializedName("quarter") val quarter : String,
		@SerializedName("_id") val _id : Int
)

fun Records.year() = quarter.split("-").first()

fun Records.quarterName() = quarter.split("-")[1]