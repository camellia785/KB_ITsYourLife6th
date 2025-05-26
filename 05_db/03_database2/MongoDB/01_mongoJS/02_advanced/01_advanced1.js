// users 컬렉션에 {username: "smith"} 문서를 추가하세요.
db.users.insertOne({username: "smith"})
// db.users.deleteOne({ username: "smith" })

db.users.find()

// 위의 문서를 다음과 같이 되도록 수정하세요.
// db.컬렉션.updateOne(쿼리문서, 갱신문서, 옵션)
// updateOne, updateMany, replaceOne도 동일하게 작동
db.users.updateOne({username: "smith"}, {
    $set: {
        favorites: {
            cities: ["Chicago", "Cheyenne"],
            movies: ["Casablanca", "For a Few Dollars More", "The Sting"]
        }
    },
})
db.users.find()
db.users.find({ username: "smith" }, { _id: 0, age: 0 })  // _id 숨기기

