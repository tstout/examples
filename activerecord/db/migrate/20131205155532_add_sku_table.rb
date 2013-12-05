class AddSkuTable < ActiveRecord::Migration
  def up
    create_table :t_skus do |t|
      t.integer :sku_id
      t.string :name, limit: 200
      t.timestamps
    end
  end

  def down
    drop_table :t_skus
  end
end
