// users 컬렉션의 "Casablanca" 영화를 좋아하는 사용자들을 출력하세요.
db.users.find({"favorites.movies":"Casablanca"})

// users 컬렉션의 "Casablanca" 영화를 좋아하는 사용자들에 대해서 좋아하는 영화 목록에
// "The Maltese Falcon"을 중복 없이 추가하세요.
db.users.updateMany(
    {"favorites.movies":"Casablanca"},
    {$addToSet: {"favorites.movies": "The Maltese Falcon" } } // addToSet으로 이미 중복 방지
)

db.users.find({"favorites.movies": "Casablanca"})

