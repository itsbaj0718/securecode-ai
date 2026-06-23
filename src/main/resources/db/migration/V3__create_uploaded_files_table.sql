CREATE TABLE uploaded_files (
    id BIGSERIAL PRIMARY KEY,

    project_id BIGINT NOT NULL,

    file_name VARCHAR(500) NOT NULL,

    file_type VARCHAR(50) NOT NULL,

    file_content TEXT NOT NULL,

    uploaded_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_file_project
        FOREIGN KEY (project_id)
        REFERENCES projects(id)
        ON DELETE CASCADE
);