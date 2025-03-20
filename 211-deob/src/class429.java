import java.io.UnsupportedEncodingException;

public class class429 implements class428 {

    JSONObject field3809;

    public class429(byte[] var1) throws UnsupportedEncodingException {
        this.method2212(var1);
    }

    public class429(JSONObject var1) {
        this.field3809 = var1;
    }

    public class429(String var1) throws UnsupportedEncodingException {
        this.method2208(var1);
    }

    public class427 vmethod2213() {
        return class427.field3808;
    }

    public byte[] vmethod7797() throws UnsupportedEncodingException {
        return this.field3809 == null ? new byte[0] : this.field3809.toString().getBytes("UTF-8");
    }

    void method2212(byte[] var1) throws UnsupportedEncodingException {
        String var2 = new String(var1, "UTF-8");
        this.method2208(var2);
    }

    void method2208(String var1) throws UnsupportedEncodingException {
        try {
            if (var1.charAt(0) == '{') {
                this.field3809 = new JSONObject(var1);
            } else {
                if (var1.charAt(0) != '[') {
                    throw new UnsupportedEncodingException("Invalid JSON passed to the JSON content builder.");
                }

                JSONArray var2 = new JSONArray(var1);
                this.field3809 = new JSONObject();
                this.field3809.method2546("arrayValues", var2);
            }

        } catch (JSONException var3) {
            throw new UnsupportedEncodingException(var3.getMessage());
        }
    }

    public JSONObject method2209() {
        return this.field3809;
    }
}
