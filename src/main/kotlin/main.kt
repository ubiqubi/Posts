// Класс, представляющий пост
data class Post(
    val id: Int, // идентификатор записи
    val toId: Int, // идентификатор владельца стены
    val fromId: Int, // идентификатор автора записи
    val createdBy: Int, // идентификатор администратора, который опубликовал запись
    val date: Int, // время публикации записи в формате unixtime
    val text: String, // текст записи
    val replyOwnerId: Int, // идентификатор владельца записи, на которую была оставлена текущая
    val replyPostId: Int, // идентификатор записи, на которую была оставлена текущая
    val friendsOnly: Boolean, // если запись была создана с опцией "только для друзей"
    val likes: Likes,
    val comments: Comments
)

// Класс, представляющий комментарии
data class Comments(
    val count: Int, // количество комментариев
    val canPost: Boolean, // информация о том, может ли текущий пользователь комментировать запись
    val groupsCanPost: Boolean, // информация о том, могут ли сообщества комментировать запись
    val canClose: Boolean, // может ли текущий пользователь закрыть комментарии к записи
    val canOpen: Boolean // может ли текущий пользователь открыть комментарии к записи
)


// Класс, представляющий отметки "Мне нравится"
data class Likes(
    val count: Int, // число пользователей, которым понравилась запись
    val userLikes: Boolean, // наличие отметки "мне нравится" от текущего пользователя
    val canLike: Boolean, // информация о том, может ли текущий пользователь поставить отметку "мне нравится"
    val canPublish: Boolean // информация о том, может ли текущий пользователь сделать репост записи
)


// Добавление поста в массив
object WallServicePost {
    private var posts = arrayListOf<Post>() // массив, хранящий все посты

    // Метод для добавления поста в массив
    fun add(post: Post): Post {
        posts += post
        return posts.last()
    }
}


// Пример использования
fun main() {
    val likes = Likes (1,true,true,true)
    val comments = Comments  (1,true,true,true,true)
    // Создание класса Post
    val post = Post(
        id = 1,
        toId = 2,
        fromId = 3,
        createdBy = 3,
        date = 1634567890,
        text = "Привет, мир!",
        replyOwnerId = 4,
        replyPostId = 5,
        friendsOnly = false,
        likes = likes,
        comments = comments
    )


    println(post)
}