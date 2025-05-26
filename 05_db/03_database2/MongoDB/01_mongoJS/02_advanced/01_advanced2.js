// users 컬렉션에 {username: “jones"} 문서를 추가하세요.
db.users.insertOne({username: "jones"})
db.users.find()

// 위의 문서를 다음과 같이 되도록 수정하세요
db.users.updateOne({username: "jones"}, {
    $set: {
        favorites: {
            movies: ["Casablanca", "Rocky"]
        }
    }
})

db.users.find()
db.users.find({ username: "jones" }, { age: 0})
