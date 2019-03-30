package kr.hs.dgsw.coordinatorpr;

public class MemoItem {
    //리사이클러뷰에서 아이템 데이터 나타냄
    public String category;
    public String memo;
    public String date;

    public MemoItem(String category, String memo) {
        this.category = category;
        this.memo = memo;
        this.date = "2019-01-26";
    }
}

