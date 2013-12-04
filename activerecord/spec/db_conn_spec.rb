require 'rspec'
require 'rubygems'
require 'active_record'
require 'require_all'
require 'yaml'
require 'logger'

describe 'DB Connection' do

  it 'should connect to DB' do
    db_config = YAML::load(File.open('db/database.yml'))

    ActiveRecord::Base::establish_connection(db_config['development'])
    ActiveRecord::Base.logger = Logger.new(STDOUT)

    class T_Category < ActiveRecord::Base
    end

    puts T_Category.count
  end
end