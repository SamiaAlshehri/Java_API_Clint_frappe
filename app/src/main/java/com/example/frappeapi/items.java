package com.example.frappeapi;

import org.json.JSONObject;

public class items {
    public String getItemname() {
        return itemname;
    }

    public String itemname;
    public String Item_Group;
    public String imge;

    public void setImge(String imge) {
        this.imge = imge;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String desc;
    public String getImge() {
        return imge;
    }

    public String getDesc() {
        return desc;
    }



    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public void setItem_Group(String item_Group) {
        Item_Group = item_Group;
    }

    public void setName(String name) {
        Name = name;
    }

    private String Name;
}
