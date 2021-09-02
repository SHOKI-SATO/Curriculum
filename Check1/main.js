let numbers = [2, 5, 12, 13, 15, 18, 22];
//ここに答えを実装してください。↓↓↓
function isEven() {
    for(let i=0; i<numbers.length; i++){
        if(numbers[i]%2==0){
            console.log(numbers[i] + 'は偶数です');
        }
    }
}
isEven();

class Car{
    constructor(num, gass){
        this.num = num;
        this.gass = gass;
    }
    getNumGas(){
        console.log(`ガソリンは${this.num}です。ナンバーは${this.gass}です。`);
    }
}
let sample = new Car(1234, 20,5);
sample.getNumGas();
