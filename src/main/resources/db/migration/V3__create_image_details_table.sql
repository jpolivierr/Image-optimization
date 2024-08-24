CREATE TABLE IF NOT EXISTS image_details (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(100),
    tags VARCHAR(100),
    category VARCHAR(100),
    host VARCHAR(250) NOT NULL,
    `path` VARCHAR(250) NOT NULL,
    date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT unique_host_path UNIQUE (host, `path`)
);

CREATE TABLE IF NOT EXISTS users_image_details (
    user_id BIGINT NOT NULL,
    image_details_id BIGINT NOT NULL,
    role VARCHAR(100),
    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_image_details_id FOREIGN KEY (image_details_id) REFERENCES image_details(id),
    PRIMARY KEY (user_id, image_details_id)
);

