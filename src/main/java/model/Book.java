package model;

public class Book{
    private final Integer id;
    private final String title;
    private final String author;
    private boolean isIssued;
    private Integer currentReaderId;

    public Book(Integer id, String title, String author){
        this.id =id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
        this.currentReaderId = null;
    }

    public Integer getId(){
        return  id;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public boolean isIssued(){
        return isIssued;
    }

    public void setIssued(boolean issued){
        isIssued = issued;
    }

    public Integer getCurrentReaderId(){
        return currentReaderId;
    }
    public void setCurrentReaderId(Integer currentReaderId){
        this.currentReaderId = currentReaderId;
    }
}