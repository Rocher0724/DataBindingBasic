package choongyul.android.com.databinding;

/**
 * Created by myPC on 2017-03-16.
 */

public class User {
    String name;
    int age;
    String imgUrl;

    public User(String name,int age,String imgUrl){
        this.name=name;
        this.age=age;
        this.imgUrl=imgUrl;

    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getImgUrl() {
        return imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

}
