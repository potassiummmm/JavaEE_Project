# JavaEE Project Report

Final project of JavaEE course,Fall 2020,Tongji University

## Project Preview

#### Team Members:

| Full Name | Matriculation Number | Contact Number | email address |
| ------ | ------ | ------ | ------ |
| Chenwei Ruan | 1850061 |||
| Zhichen Ren | 1850091 |13917219912|1337795211@qq.com|
| Zhengyi Zhuo | 1850384 |||
| Hansong Zhou | 1852612 | 18897958786 | 1574996073@qq.com |

## System Functionalities

- Register & Login & Logout

- Send new blogs when login(support markdown syntax)

- Comment blogs when login

- View comments of a blog

- Like and Star blogs when login

- See who likes your blog

- Sort blogs on index page by date or like



## User Manual

- Use nickname, e-mail address, password to register a new account, the password's length should longer than 7 characters and less than  17 characters.
- After register, you can use the e-mail address and password to sign in.
- Before login, there are only Home and Sign In button on home page.
- You can see all blogs and comments as a visitor, but cannot send blogs, comment blogs, like blogs or star blogs.
- You can choose the sorting method of the blogs in the home page, the default method is sort by date.
- After login, you can do all actions mentioned before.
- When sending blogs, you can use markdown syntax.
- When sending blogs or writing comment, your submit will be checked. If your message contains sensitive words, your submission will fail.
- After login, About button, which is your nick name,  and Send Blog button will be added to the home page, the Sign In button will be replaced by the Log Out button.
- In About page, you can see the blogs you sent and the blogs you stared, you can also delete your blogs or stared blogs

## System Architecture and Component Design

- Dao layer to connect database
- Service layer to offer business logic
- Controller layer to deal with URL request , add models and return the View layer, which is responsible for interacting with users
- 

## Database Design

###

## Other Technical Details and/or Information