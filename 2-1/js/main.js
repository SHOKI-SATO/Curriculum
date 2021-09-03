//windowオブジェクトの中身をconsole.logで確認してみます。
console.log(window);

//①location.hrefでURLを取得して、変数urlに代入。
let url = window.location.href;

//②ブラウザを更新すると、URLが表示されます。
console.log(url);

window.alert('Hello World');
