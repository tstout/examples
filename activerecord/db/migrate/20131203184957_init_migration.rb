class InitMigration < ActiveRecord::Migration
  def change
    create_table :t_categories do |t|
      t.integer :parent_id
      t.boolean :root_ind
      t.string :name
      t.string :description
      t.text :header_copy
      t.text :related_links
      t.date :activate_date
      t.date :deactivate_date
      t.string :section_image
      t.string :browse_image
      t.string :template
      t.integer :category_order
      t.string :url
      t.integer :alias_id
      t.string :calculated_image
      t.integer :lock_version, default: 0

      t.timestamps
    end
  end

  create_table :t_products do |t|
    t.string :name
    t.datetime :activate_date
    t.datetime :deactivate_date
    t.string :product_manual_url
    t.string :assembly_guide_url
    t.string :header_copy, limit: 1000
    t.string :more_information, limit: 2000
    t.string :keywords, limit: 1000
    t.string :negative_keywords, limit: 1000
    t.string :parking_lot_copy, limit: 1500
    t.boolean :exclude_from_recommendations, default: false
    t.boolean :is_collection, default: false
    t.boolean :show_how_we_measure, default: false
    t.boolean :exclude_from_new_product_feed, default: false
    t.integer :lock_version, default: 0

    t.timestamps
  end

  create_table :t_media_items do |t|
    t.string :name
    t.integer :length
    t.binary :data

    t.timestamps
  end
end
