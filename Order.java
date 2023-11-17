


class Order {
      int id;
    LinkedList<Item> items;

    public Order(int i) {
       id=i;
        items = new LinkedList<>();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public  void AddItem(Item itm){
    items.addLast(itm);
     
    }
    
    public float total_cost()
    {
    float totalCost=0;
    for(int i=0;i<items.size();i++)
    {
      Item t=items.removeFirst();
    totalCost+=t.getCost()*t.getCount();
    items.addLast(t);
    
    }  
    return totalCost;
    
    }
    
       public int OrderPreparingTime()
    {
    int time=0;
    for(int i=0;i<items.size();i++)
    {
      Item t=items.removeFirst();
    time+=t.getPreparingTime();
    items.addLast(t);
    
    }  
    return time;
    
    }
       
    public  void printOrder(){
        System.out.println("Order id "+id);
        items.print();
    
    
    }   
       
       
}
