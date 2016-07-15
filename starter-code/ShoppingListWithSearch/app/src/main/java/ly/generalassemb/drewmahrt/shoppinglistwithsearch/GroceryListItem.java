package ly.generalassemb.drewmahrt.shoppinglistwithsearch;

/**
 * Created by stacyzolnikov on 7/14/16.
 */
public class GroceryListItem {
    int id;
    String mName;
    String mDescription;
    String mType;
    double mPrice;

    public GroceryListItem() {

    }

    public GroceryListItem(int id, String name, String description, String type, double price) {
        this.id = id;
        this.mName = name;
        this.mDescription = description;
        this.mType = type;
        this.mPrice = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public double getmPrice() {
        return mPrice;
    }

    public void setmPrice(double mPrice) {
        this.mPrice = mPrice;
    }
}
