--DROP ALL OBJECTS;
DROP TABLE IF EXISTS users, requests, items, bookings, comments CASCADE;

CREATE TABLE IF NOT EXISTS users
(
    id    BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name  VARCHAR NOT NULL,
    email VARCHAR NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS requests
(
    id           BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    description  VARCHAR                     NOT NULL,
    requester_id BIGINT                      NOT NULL,
    create_date  TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT fk_requests_to_users FOREIGN KEY (requester_id) REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS items
(
    id           BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name         VARCHAR NOT NULL,
    description  VARCHAR NOT NULL,
    is_available BOOLEAN NOT NULL,
    owner_id     BIGINT  NOT NULL,
    request_id   BIGINT,
    CONSTRAINT fk_items_to_users FOREIGN KEY (owner_id) REFERENCES users (id),
    CONSTRAINT fk_items_to_requests FOREIGN KEY (request_id) REFERENCES requests (id)
);

CREATE TABLE IF NOT EXISTS bookings
(
    id         BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    start_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    end_date   TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    item_id    BIGINT                      NOT NULL,
    booker_id  BIGINT                      NOT NULL,
    status     VARCHAR                     NOT NULL,
    CONSTRAINT fk_bookings_to_items FOREIGN KEY (item_id) REFERENCES items (id),
    CONSTRAINT fk_bookings_to_users FOREIGN KEY (booker_id) REFERENCES users (id),
    CONSTRAINT constr_status CHECK (status IN ('WAITING', 'APPROVED', 'REJECTED', 'CANCELED'))
);

CREATE TABLE IF NOT EXISTS comments
(
    id          BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    text        VARCHAR                     NOT NULL,
    item_id     BIGINT                      NOT NULL,
    author_id   BIGINT                      NOT NULL,
    create_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT fk_comments_to_items FOREIGN KEY (item_id) REFERENCES items (id),
    CONSTRAINT fk_comments_to_users FOREIGN KEY (author_id) REFERENCES users (id)
);