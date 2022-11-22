## Description

Idea of this project is to have blog platform where people 
could share their articles and each article has dedicated author.

## Requiremnts

In order to run the server we need to have SQL database up and running with all necessary
tables created.

After starting Postgres SQL server put address and credentials for this server into `application.properties` file.

There should be next tables:

#### Article
| Name     | Data type |
|----------|-----------|
| id       | BIGSERIAL |
| date     | DATE      |
| header   | VARCHAR   |
| text     | VARCHAR   |
| user_id  | BIGINT    |

#### Blog_user
| Name     | Data type |
|----------|-----------|
| id       | BIGSERIAL |
| date     | VARCHAR   |

## Features 
### Add users
There is endpoint to add users to our service:

    /user/save

In order to add a new user we need to send `POST` request to this endpoint
with body containing user's nickname in format:

    { "name": "Mike" }

Name field is mandatory.

Response will contain the newly created user `id`.

### Get all users
Endpoint to get all users:

    /user/all

After sending `GET` request to this endpoint we get response:

    [
        {
            "name": "Miki"
        },
        {
            "name": "Mike2"
        }
    ]

### Add article

Endpoint to add article

    /article/add

In order to add article we need to send `POST` request to this
endpoint with the body in format:

    {
        "userId": 1,
        "header": "Header of our article",
        "text": "Our article text"
    }

All fields are mandatory.

If user with this id doesn't exist on the server, the server will return `500` status (for now).

In case of successful operation server will return status `200` and response body will contain created article `id`.

### Get all articles

Endpoint to get all articles:

    /article/all

After sending `GET` request to this endpoint we're going to get the list of all articles
in format:

    [
        {
            "name": "Miki",
            "date": "2022-10-31T23:15:00.000+00:00",
            "header": "Miki's article header",
            "text": "Text"
        },

            "name": "Alice",
            "date": "2022-11-21T23:00:00.000+00:00",
            "header": "Alice's article header",
            "text": "Text"
        }
    ]

Where each entry contains `name` of the author, `date` when article was
added to the service, `header` and `text` of the article.

