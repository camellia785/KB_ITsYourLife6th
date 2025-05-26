db.product.find()
// product 컬렉션의 문서를 num의 내림 차순으로 정렬하여 출력하세요.
db.product.find().sort({'num': -1}).limit(15)

//product 컬렉션의 문서를 num의 내림 차순으로 정렬하여 상위 10건을 출력하세요.
db.product.find().sort({'num': -1}).limit(10)

//     product 컬렉션의 문서를 num의 내림 차순으로 정렬한 상태에서 다음을 처리하세요
// ○ 한 페이지당 10건씩 출력
// ○ 6페이지에 해당하는 문서를 출력하세요.

db.product.find()
    .sort({'num': -1})
    .skip(50) // 5*10개 문서를 건너뛰어서 6번째 페이지 보러가기
    .limit(10)

// product 컬렉션에서 num이 15미만 이거나 19995 초과인 것을 출력하세요.

db.product.find({
    '$or': [
        {'num': {'$lt': 15}},
        {'num': {'$gt': 19995}}
    ]
})

db.product.find()

// product 컬렉션에서 name이 '스마트폰 10', '스마트폰 100', '스마트폰 1000' 중에 하나이면 출력
db.product.find({
    '$or': [
        {'name':'스마트폰10'},
        {'name':'스마트폰100'},
        {'name':'스마트폰1000'},
    ]
})

// 간단하게
db.product.find({
    name: { $in: ['스마트폰10', '스마트폰100', '스마트폰1000'] }
})

// product 컬렉션에서 num이 5보다 작은 문서를 출력하는데, name만 출력하세요.
// (_id 출력하면 안됨)
db.product.find(
    {num: { $lt: 5}}, // query
    {_id: 0, name: 1} // projection
)