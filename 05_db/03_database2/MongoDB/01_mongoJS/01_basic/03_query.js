// 다음 형태의 문서 20,000건을 추가하세요.
// ○ database: test
// ○ collection: product
// ○ 문서 필드
//  num: 순번 (0부터 시작)
//  name: '스마트폰 ' + 순번

for(let i=0; i<20000; i++ ){
    db.product.insertOne({
        num: i,
        name: '스마트폰' + i
    })
}

//product 컬렉션의 전체 문서수를 출력하세요.
db.product.find()
db.product.stats()