package Bean;

import java.io.Serial;
import java.io.Serializable;

public class Movie implements Serializable {
    @Serial
    private static final long serialVersionUID=1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 电影名
     */
    private String name;

    /**
     * 导演
     */
    private String director;

    /**
     * 主演
     */
    private String starring;

    /**
     * 类型
     */
    private String movieType;

    /**
     * 时长
     */
    private String movieTime;

    /**
     * 场次
     */
    private String session;

    /**
     * 演播厅
     */
    private String room;

    /**
     * 价格
     */
    private String price;


    public Movie() {
    }

    public Movie(Integer id, String name, String director, String starring, String movieType, String movieTime) {
        super();
        this.id = id;
        this.name = name;
        this.director = director;
        this.starring = starring;
        this.movieType = movieType;
        this.movieTime = movieTime;
    }



    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return director
     */
    public String getDirector() {
        return director;
    }

    /**
     * 设置
     * @param director
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * 获取
     * @return starring
     */
    public String getStarring() {
        return starring;
    }

    /**
     * 设置
     * @param starring
     */
    public void setStarring(String starring) {
        this.starring = starring;
    }

    /**
     * 获取
     * @return movieType
     */
    public String getMovieType() {
        return movieType;
    }

    /**
     * 设置
     * @param movieType
     */
    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    /**
     * 获取
     * @return movieTime
     */
    public String getMovieTime() {
        return movieTime;
    }

    /**
     * 设置
     * @param movieTime
     */
    public void setMovieTime(String movieTime) {
        this.movieTime = movieTime;
    }

    public String toString() {
        return "Movie{serialVersionUID = " + serialVersionUID + ", id = " + id + ", name = " + name + ", director = " + director + ", starring = " + starring + ", movieType = " + movieType + ", movieTime = " + movieTime + "}";
    }

    /**
     * 获取
     * @return session
     */
    public String getSession() {
        return session;
    }

    /**
     * 设置
     * @param session
     */
    public void setSession(String session) {
        this.session = session;
    }

    /**
     * 获取
     * @return room
     */
    public String getRoom() {
        return room;
    }

    /**
     * 设置
     * @param room
     */
    public void setRoom(String room) {
        this.room = room;
    }

    /**
     * 获取
     * @return price
     */
    public String getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(String price) {
        this.price = price;
    }
}
