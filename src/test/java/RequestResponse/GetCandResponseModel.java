package RequestResponse;

import RequestResponse.SubClasses.Datum;
import RequestResponse.SubClasses.Meta;

import java.util.ArrayList;

public class GetCandResponseModel {
    public ArrayList<Datum> data;
    public Meta meta;
    public ArrayList<Object> rels;

    public ArrayList<Datum> getData() {
        return data;
    }

    public void setData(ArrayList<Datum> data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public ArrayList<Object> getRels() {
        return rels;
    }

    public void setRels(ArrayList<Object> rels) {
        this.rels = rels;
    }
}
