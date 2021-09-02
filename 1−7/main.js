class Taiyaki{
    constructor(nakami){
        this.nakami = nakami;
    }
    print(){
        console.log(`中身は${this.nakami}です`)
    }
}

let anko = new Taiyaki('あんこ');
anko.print();
let cream = new Taiyaki('クリーム');
cream.print();
let cheese = new Taiyaki('チーズ');
cheese.print();


