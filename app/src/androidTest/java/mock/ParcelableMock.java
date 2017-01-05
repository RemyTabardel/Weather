package mock;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by TABARDEL_Remy on 05/01/2017.
 */

public class ParcelableMock {
    public static <T> T newInstance(Parcelable parcelable, Parcelable.Creator<T> creator) {
        Parcel parcel = Parcel.obtain();
        parcelable.writeToParcel(parcel, parcelable.describeContents());
        parcel.setDataPosition(0);

        return creator.createFromParcel(parcel);
    }
}
