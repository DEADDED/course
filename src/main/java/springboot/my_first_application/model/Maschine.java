    package springboot.my_first_application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
    public class Maschine {
    	@Id
    	  @GeneratedValue(strategy=GenerationType.IDENTITY)
      Long id;
      Float price;
      String src;
      String name;
      Integer maxkg;
      String type;
      Integer depth;
      Integer width;
      Integer height;
      Integer weight;
      Integer maxturns;
      public Maschine() { }
      public Maschine(Long id,Float price, String src, String name, Integer maxkg, String type, Integer depth, Integer width, Integer height, Integer weight, Integer maxturns) {
        this.price = price;
    	this.id = id;
        this.src = src;
        this.name = name;
        this.maxkg = maxkg;
        this.type = type;
        this.depth = depth;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.maxturns = maxturns;
      }
      public Long getId() {
        return id;
      }
      public void setId(Long id) {
        this.id = id;
      }
      public Float getPrice() {
    	  return price;
      }
      public void setPrice(Float price) {
    	  this.price = price;
      }
      public String getSrc() {
    	  return src;
      }
      public void setSrc(String src) {
    	  this.src = src;
      }
      public String getName() {
        return name;
      }
      public void setName(String name) {
        this.name = name;
      }
      public Integer getMaxkg() {
    	  return maxkg;
      }
      public void setMaxkg(Integer maxkg) {
    	  this.maxkg = maxkg;
      }
      public String getType() {
        return type;
      }
      public void setType(String type) {
        this.type = type;
      }
      public Integer getDepth() {
        return depth;
      }
      public void setDepth(Integer depth) {
        this.depth = depth;
      }
      public Integer getWidth() {
        return width;
      }
      public void setWidth(Integer width) {
        this.width = width;
      }
      public Integer getHeight() {
        return height;
      }
      public void setHeight(Integer height) {
        this.height = height;
      }
      public Integer getWeight() {
        return weight;
      }
      public void setWeight(Integer weight) {
        this.weight = weight;
      }
      public Integer getMaxturns() {
    	  return maxturns;
      }
      public void setMaxturns(Integer maxturns) {
    	  this.maxturns = maxturns;
      }
      
    }