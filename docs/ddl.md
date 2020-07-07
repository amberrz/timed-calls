## Data Definition Language (DDL)

```sqlite
CREATE TABLE IF NOT EXISTS `History`
(
    `history_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `duration`   INTEGER                           NOT NULL,
    `date`       INTEGER,
    `timer_id`   INTEGER                           NOT NULL,
    FOREIGN KEY (`timer_id`) REFERENCES `Timer` (`timer_id`)
        ON UPDATE NO ACTION ON DELETE SET NULL
);

CREATE INDEX IF NOT EXISTS `index_History_timer_id` ON `History` (`date`);

CREATE TABLE IF NOT EXISTS `Timer`
(
    `timer_id`    INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `limit`       INTEGER                           NOT NULL,
    `contact_uri` TEXT                              NOT NULL
);

CREATE UNIQUE INDEX IF NOT EXISTS `index_Timer_contact_uri` ON `Timer` (`contact_uri`);
```

[`ddl.sql`](sql/ddl.sql)
