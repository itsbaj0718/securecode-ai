CREATE TABLE scan_results (

    id BIGSERIAL PRIMARY KEY,

    uploaded_file_id BIGINT NOT NULL,

    rule_name VARCHAR(255) NOT NULL,

    severity VARCHAR(50) NOT NULL,

    line_number INTEGER,

    description TEXT,

    recommendation TEXT,

    status VARCHAR(50) DEFAULT 'OPEN',

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_uploaded_file
        FOREIGN KEY(uploaded_file_id)
        REFERENCES uploaded_files(id)
        ON DELETE CASCADE
);