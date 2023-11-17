
class Item {
  private  int id;
   private String name;
   private int preparingTime;
   private float cost;
   private Integer count;
   
    public Item(int id, String name, int preparingTime, float cost, Integer count) {
        this.id = id;
        this.name = name;
        this.preparingTime = preparingTime;
        this.cost = cost;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPreparingTime() {
        return preparingTime;
    }

    public void setPreparingTime(int preparingTime) {
        this.preparingTime = preparingTime;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "\nItem{" + "id=" + id + ", name=" + name + ", preparingTime=" + preparingTime + ", cost=" + cost + ", count=" + count + '}';
    }

   
    
    

}

