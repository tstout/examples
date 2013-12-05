class TSku < ActiveRecord::Base
  has_many :t_media_items, as: :media
end